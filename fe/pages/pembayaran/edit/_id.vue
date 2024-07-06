<template>
  <v-row>
    <!-- Input Fields -->
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar :color="$vuetify.theme.themes.dark.primary" dark >UBAH PEMBAYARAN</v-toolbar>
        <v-card-text>
          <v-alert v-if="message" color="red lighten-2" >{{ $t(message) }}</v-alert>
          <v-breadcrumbs :items="breadcrumbs" class="pa-0"></v-breadcrumbs>
          <v-form ref="form">
            <v-text-field
                name="tgl_pembayaran"
                label="Tanggal Pembayaran"
                type="date"
                :rules="rules.tgl_pembayaran"
                v-model="form.tgl_pembayaran"
            />
            <v-text-field
                name="jumlah_bayar"
                label="Jumlah Bayar"
                type="number"
                :rules="rules.jumlah_bayar"
                v-model="form.jumlah_bayar"
            />
            <v-text-field
                name="metode_bayar"
                label="Metode Bayar"
                type="text"
                :rules="rules.metode_bayar"
                v-model="form.metode_bayar"
            />
            <v-select
                v-model="form.id_ta"
                :items="tahun_ajaran"
                label="Tahun Ajaran"
                :rules="rules.tahun_ajaran"
            ></v-select>
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-btn to="/pembayaran" :color="$vuetify.theme.themes.dark.accent" dark>Back</v-btn>
          <v-spacer />
          <v-btn @click="doSave" :color="$vuetify.theme.themes.dark.secondary" dark :loading="btnSaveDisable">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  head: {
    title: "Ubah Pembayaran",
  },
  asyncData({ params }) {
    return {
      id: params.id,
    };
  },
  data() {
    return {
      breadcrumbs: [
        { text: "Pembayaran", to: "/pembayaran", disabled: false, exact: true },
        { text: "Ubah", disabled: true },
      ],
      btnSaveDisable: false,
      message: "",
      tahun_ajaran: [],
      form: {
        id: 0,
        id_ta: 0,
        id_siswa: 0,
        tgl_pembayaran: "",
        jumlah_bayar: "",
        metode_bayar: "",
      },
      rules: {
        tgl_pembayaran: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tanggal Pembayaran" })],
        jumlah_bayar: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Jumlah Bayar" })],
        metode_bayar: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Metode Bayar" })],
        tahun_ajaran: [(v) => !!v || this.$t("FIELD_IS_REQUIRED", { field: "Tahun Ajaran" })],
      },
    };
  },
  methods: {
    doSave() {
      this.message = "";

      if (this.$refs.form.validate()) {
        this.btnSaveDisable = true;

        try {
          this.form.id = this.id;
          this.$axios.$put("/pembayaran", this.form)
              .then((res) => {
                this.$router.push({
                  name: `pembayaran___${this.$i18n.locale}`,
                  params: {
                    type: "success",
                    message: res.messages,
                    title: this.form.jumlah_bayar,
                  },
                });
              })
              .catch((err) => {
                this.$router.push({
                  name: `pembayaran___${this.$i18n.locale}`,
                  params: {
                    type: "error",
                    message: err.messages,
                    title: this.form.nama_lengkap,
                  },
                });
              })
        } catch (error) {
          console.error('Error:', error);
          this.message = "An error occurred while saving.";
        } finally {
          this.btnSaveDisable = false;
        }
      }
    },
    getData() {
      try {
        this.$axios.$get(`/pembayaran/${this.id}`)
            .then((res) => {
              console.log(res)
              const {data} = res;
              this.form.tgl_pembayaran = data.tgl_pembayaran
              this.form.jumlah_bayar = data.jumlah_bayar
              this.form.metode_bayar = data.metode_bayar
              this.form.id_ta = data.id_ta
              this.form.id_siswa = data.id_siswa
            })
      } catch (error) {
        console.error('Error:', error);
      }
    },
    getTahunAjaran() {
      this.isLoading = true;

      this.$axios
          .$get(`/tahun-ajaran?page=-1&limit=-1&search=`)
          .then((res) => {
            const { data } = res;

            data.forEach(item => {
              this.tahun_ajaran.push({
                text: item.periode,
                value: item.id,
              })
            })
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => {
            this.isLoading = false;
          });
    },
  },
  async mounted() {
    await this.getTahunAjaran();
    this.getData();
  },
};
</script>
