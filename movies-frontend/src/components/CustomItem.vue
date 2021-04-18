<template>
  <q-item clickable tag="a" :to="url">
    <q-item-section avatar>
      <q-icon :name="iconName" />
    </q-item-section>
    <q-item-section>
      <q-item-label>{{label}}</q-item-label>
      <q-item-label caption>{{subLabel}}</q-item-label>
    </q-item-section>
  </q-item>
</template>

<script>
export default {
  props: {
    url: {
      type: String,
      required: true,
      default: '/'
    },
    iconName: {
      type: String,
      required: true
    },
    label: {
      type: String,
      required: false,
      default: ''
    },
    subLabel: {
      type: String,
      required: false,
      default: ''
    }
  }
}
</script>

<style lang="stylus" scoped>
</style>
