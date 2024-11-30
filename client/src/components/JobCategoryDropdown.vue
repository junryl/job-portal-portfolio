<template>
  <div class="w-full max-w-sm min-w-[400px]">
    <div class="relative">
      <select
        @change="onChange($event)"
        class="w-full bg-transparent placeholder:text-slate-400 text-slate-700 text-sm border border-slate-200 rounded pl-3 pr-8 py-2 transition duration-300 ease focus:outline-none focus:border-slate-400 hover:border-slate-400 shadow-sm focus:shadow-md appearance-none cursor-pointer"
      >
        <option
          v-for="category in categories"
          :key="category.id"
          :value="category.id"
        >
          {{ category.name }}
        </option>
      </select>
      <svg
        xmlns="http://www.w3.org/2000/svg"
        fill="none"
        viewBox="0 0 24 24"
        stroke-width="1.2"
        stroke="currentColor"
        class="h-5 w-5 ml-1 absolute top-2.5 right-2.5 text-slate-700"
      >
        <path
          stroke-linecap="round"
          stroke-linejoin="round"
          d="M8.25 15 12 18.75 15.75 15m-7.5-6L12 5.25 15.75 9"
        />
      </svg>
    </div>
  </div>
</template>

<script>
import categoryList from "../data/category.json";

export default {
  name: "JobCategoryDropdown",
  props: {},
  data() {
    return {
      categories: [
        {
          id: "999",
          name: "Select One",
          count: "0",
        },
        ...categoryList
      ],
    };
  },
  mounted() {
  },
  methods: {
    onChange(event) {
      this.$emit("categorySelected", event.target.value);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>