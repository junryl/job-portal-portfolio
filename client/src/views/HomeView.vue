<template>
    <div>
      <div class="flex p-5">
        <div class="flex-initial"><JobCategory /></div>
        <div class="flex-1"><JobView /></div>
      </div>
    </div>
</template>

<script>
import JobView from '../views/JobView.vue';
import JobCategory from '../components/JobCategory.vue';
import commonMixin from '../mixins/commonMixin';

export default {
  name: "HomeView",
  mixins: [commonMixin],
  components: {
    JobCategory,
    JobView
  },
  async mounted(){
    await this.loadJobs();
  },
  methods:{

  }
};
</script>

<style>
</style>
