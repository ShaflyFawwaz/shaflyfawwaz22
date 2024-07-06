<template>
  <v-app>
      <v-app-bar disable-resize-watcher fixed app :color="$vuetify.theme.themes.dark.primary" dark>
        <v-toolbar-title>
          <span class="white--text" >Sistem Informasi Sekolah</span>
        </v-toolbar-title>
        <v-spacer></v-spacer>
      </v-app-bar>
    <v-navigation-drawer disable-resize-watcher fixed app :color="$vuetify.theme.themes.dark.primary" dark>
      <v-list>
        <v-list-item
          v-for="(item, i) in sideMenu"
          :key="i"
          :to="item.to"
          router
          exact
        >
          <v-list-item-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <v-container fill-height fluid>
        <Nuxt />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: "DefaultLayout",
  data() {
    return {
      sideDrawer: false,
      sideMenu: [
        {
          icon: "mdi-view-dashboard-edit-outline",
          title: "Dashboard",
          to: "/",
        },
        {
          icon: "mdi-calendar-cursor-outline",
          title: "Tahun Ajaran",
          to: "/tahun-ajaran",
        },
        {
          icon: "mdi-school",
          title: "Siswa",
          to: "/siswa",
        },
        {
          icon: "mdi-credit-card-search-outline",
          title: "Pembayaran",
          to: "/pembayaran",
        },
        {
          icon: "mdi-account-cash",
          title: "Transaksi",
          to: "/transaksi",
        },
        {
          icon: "mdi-receipt-text-edit",
          title: "Tagihan SPP",
          to: "/tagihan-spp",
        },
        {
          icon: "mdi-collage",
          title: "Komponen",
          to: "/komponen",
        },
        {
          icon: "mdi-format-list-checkbox",
          title: "Tagihan Lain",
          to: "/tagihan-lain",
        },
      ],
    };
  },
  mounted() {
    this.$router.push("/")
  },
};
</script>
