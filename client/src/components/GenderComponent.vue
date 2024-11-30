<template>
  <div class="flex">
    <div class="flex flex-row mr-4">
      <input
        type="radio"
        value="male"
        name="genderOption"
        @change="genderSelected"
        class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
      />
      <label
        for="default-radio-1"
        class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300"
        >Male</label
      >
    </div>

    <div class="flex flex-row mr-4">
      <input
        type="radio"
        value="female"
        name="genderOption"
        @change="genderSelected"
        class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600"
      />
      <label
        for="default-radio-1"
        class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300"
        >Female</label
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "GenderComponent",
  props: {},
  data() {
    return {
    };
  },
  mounted() {},
  methods: {
    genderSelected(event){
      this.$emit('changeGender', event.target.value)
    }
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>