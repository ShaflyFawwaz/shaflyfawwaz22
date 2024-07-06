<template>
  <v-row>
    <v-col cols="10" offset="1">
      <v-card class="mb-2">
        <v-toolbar :color="$vuetify.theme.themes.dark.primary" dark>Dashboard</v-toolbar>
        <v-card-text><h2>Hello, Guys!</h2></v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default({
  head: {
    title: 'Dashboard'
  },
})
</script>