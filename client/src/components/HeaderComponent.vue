<template>
  <div class="w-full h-32 flex-col">
    <router-link to="/">
      <img src="../assets/logo.png" alt="" />
    </router-link>
    <div class="text-right mr-5">
      <router-link to="/login">
        <button
          class="bg-transparent hover:bg-blue-500 text-blue-500 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded w-32 mr-5"
        >
          Login
        </button>
      </router-link>
      <router-link to="/postJob">
        <button
          class="bg-transparent hover:bg-pink-600 text-pink-600 font-semibold hover:text-white py-2 px-4 border border-pink-500 hover:border-transparent rounded w-32"
        >
          Post a Job
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "HeaderComponent",
  props: {},
  data() {
    return {};
  },
  mounted() {
    console.log("mounted");
  },
  methods: {},
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
