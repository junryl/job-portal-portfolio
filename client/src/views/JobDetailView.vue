<template>
  <div>
    <div class="flex p-5 divide-x-2">
      <div class="flex-initial"><JobCategory /></div>
      <div class="flex-1 p-8">
        <div v-if="!this.jobItem" class="text-red-500">
          Item does not exist!
        </div>
        <div v-else class="flex flex-col text-left">
          <div>
            <h5 class="text-xl font-semibold text-pink-500">
              {{ this.jobItem.position }}
            </h5>
          </div>
          <div>
            <h6 class="mb-2 text-slate-800 leading-normal font-light">
              {{ this.jobItem.companyName }}
            </h6>
            <p class="text-slate-600 leading-normal font-light">
              {{ this.jobItem.currency }} {{ this.jobItem.salaryRange }}
            </p>
          </div>
          <br />
          <br />
          <div class="h1"><strong>Details</strong></div>
          <p class="text-slate-600 leading-normal font-light">
            {{ this.jobItem.description }}
          </p>
          <br />
          <br />
          <QuickApply />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import JobCategory from "../components/JobCategory.vue";
import QuickApply from "../components/QuickApply.vue";
import store from "@/store";

export default {
  name: "JobDetailView",
  props: ["id"],
  components: {
    JobCategory,
    QuickApply
  },
  data() {
    return {
      jobList: store.jobs,
      jobItem: null,
    };
  },
  mounted() {
    this.findJobDetailById();
  },
  methods: {
    findJobDetailById() {
      this.jobItem = this.jobList.find((item) => item.id == this.id);
    },
  },
};
</script>

<style>
</style>