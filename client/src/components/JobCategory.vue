<template>
  <div class="text-left">
    <ul :key="key" v-for="(value, key) in categoryList">
      <li
        class="text-pink-700 cursor-pointer p-1"
        @click="filterJobs(value.id)"
      >
        {{ value.name }} ({{ value.count }})
      </li>
    </ul>
  </div>
</template>

<script>
import jobCategoryJson from "../data/category.json";
import store from "../store";
import commonMixin from "../mixins/commonMixin";

export default {
  name: "JobCategory",
  mixins: [commonMixin],
  props: {},
  data() {
    return {
      categoryList: jobCategoryJson,
    };
  },
  mounted() {},
  methods: {
    async filterJobs(jobId) {
      store.categoryFilterId = jobId;
      await this.loadJobs();

      if (this.$router.history.current.name == "home") {
        //do nothing
      } else {
        this.$router.push("/");
      }
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
