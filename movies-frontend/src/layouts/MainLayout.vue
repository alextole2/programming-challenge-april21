<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="leftDrawerOpen = !leftDrawerOpen"
        />

        <q-toolbar-title>
          {{ appName }}
        </q-toolbar-title>

        <div>Version v{{ appVersion }}</div>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
      content-class="bg-grey-1"
    >
      <q-list>
        <q-item-label
          header
          class="text-grey-8"
        >
          Menu
        </q-item-label>

        <custom-item url="/movies" iconName="local_movies" label="Movies" subLabel="Movies list" />

      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

  </q-layout>

</template>

<script>

import app from 'src/helpers/App'
import CustomItem from 'src/components/CustomItem'

export default {
  name: 'MainLayout',
  components: {
    CustomItem
  },
  data () {
    return {
      leftDrawerOpen: false,
      appName: app.getAppName(),
      appVersion: app.getAppVersion()
    }
  }
}
</script>
