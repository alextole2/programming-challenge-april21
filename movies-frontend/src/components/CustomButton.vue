<template>
  <q-btn
    flat
    dense
    round
    :icon="iconName"
    :aria-label="label"
    @click="$emit('click')"
  />
</template>

<script>
export default {
  props: {
    iconName: {
      type: String,
      required: true
    },
    label: {
      type: String,
      required: false,
      default: ''
    }
  }
}
</script>

<style lang="stylus" scoped>
</style>
