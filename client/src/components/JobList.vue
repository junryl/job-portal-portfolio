<template>
  <div class="relative">
    <div v-if="!hasJobs" class="m-auto">
      <alert-info> <h1>No jobs available as of the moment.</h1> </alert-info>
    </div>
    <div v-else :key="key" v-for="(value, key) in jobList">
      <router-link :to="{ name: 'job.detail', params: { id: value.id } }">
        <JobItem v-bind:item="value" />
      </router-link>
    </div>
  </div>
</template>

<script>
import JobItem from "./JobItem.vue";
import store from "../store.js";
import AlertInfo from "./AlertInfo.vue";

export default {
  name: "JobList",
  components: {
    JobItem,
    AlertInfo,
  },
  data() {
    return {
      jobClass: "job-inactive",
    };
  },
  mounted() {

  },
  computed: {
    hasJobs() {
      return this.jobList.length > 0 ? true : false;
    },
    jobList() {
      return store.jobs;
    },
  },
  methods: {
    toggleActive() {
      this.jobClass =
        this.jobClass === "job-active" ? "job-inactive" : "job-active";
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.job-active {
  @apply relative flex flex-row text-left p-5 m-5 rounded overflow-hidden shadow-lg border-2 border-pink-400;
}
.job-inactive {
  @apply relative flex flex-row text-left border p-5 m-5 rounded overflow-hidden shadow-lg;
}
</style>
