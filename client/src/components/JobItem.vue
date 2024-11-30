<template>
  <div :class="jobClass">
    <div class="flex flex-col w-4/12">
      <div>
        <h5 class="text-xl font-semibold text-pink-500">
          {{ this.item.position }}
        </h5>
      </div>
      <div>
        <h6 class="mb-2 text-slate-800 leading-normal font-light">
          {{ this.item.companyName }}
        </h6>
        <p class="text-slate-600 leading-normal font-light">
          {{ this.item.currency }} {{ this.item.salaryRange }}
        </p>
      </div>
    </div>
    <div class="flex flex-col w-4/12">
      <div class="flex flex-col">
        <p class="leading-normal font-light">{{ this.item.address1 }}</p>
        <p class="leading-normal font-light">{{ this.item.address2 }}</p>
      </div>
    </div>
    <div class="flex flex-col w-4/12">
      <div>
        <p v-if="this.item.noExperienceRequired == '1'">No experience</p>
        <p v-if="this.item.isRemote == '1'">Work from home</p>
        <p v-if="this.item.isHybrid == '1'">Hybrid Setup</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "JobItem",
  props: ["item"],
  data() {
    return {
      jobClass: "job-inactive",
    };
  },
  mounted() {},
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
  @apply relative flex flex-row text-left p-5 m-5 rounded overflow-hidden shadow-lg border-2 border-pink-400 cursor-pointer;
}
.job-inactive {
  @apply relative flex flex-row text-left border p-5 m-5 rounded overflow-hidden shadow-lg cursor-pointer;
}
</style>
