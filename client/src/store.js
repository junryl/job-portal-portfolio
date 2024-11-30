import Vue from 'vue';

export default Vue.observable({
  jobs: [], //job list
  categoryFilterId: null, //category filter id, to be used on filter job list by category 
});