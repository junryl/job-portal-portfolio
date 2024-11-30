<template>
  <div
    class=" p-16 mb-4 text-2xl  text-pink-700 rounded-lg bg-pink-50"
    role="alert"
  >
    <slot></slot>
  </div>
</template>
<script>
export default {
  name: "AlertInfo",
  props: {},
  data() {
    return {};
  },
  mounted() {},
  methods: {},
};
</script>

<style scoped>
</style>