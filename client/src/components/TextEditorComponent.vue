<template>
  <div>
    <div class="flex">
      <img src="../assets/bold-btn.svg" @click="updateSelectedText('bold')" class=" h-4 w-4 m-2 cursor-pointer" alt="Bold text">
      <img src="../assets/italic-btn.svg" @click="updateSelectedText('italic')" class=" h-4 w-4 m-2 cursor-pointer" alt="Bold text">
      <img src="../assets/underline-btn.svg" @click="updateSelectedText('underline')" class=" h-4 w-4 m-2 cursor-pointer" alt="Bold text">
      <!-- <img src="../assets/unordered-list-btn.svg" @click="updateSelectedText('insertOrderedList')" class=" h-6 w-6 m-1 cursor-pointer" alt="Bold text"> -->
    </div>
    <div>
    <div
      contenteditable="true"
      name="textEditorContent"
      id="textEditorContent"
      @keyup="textEntered"
      class="bg-gray-200 min-h-[100px] appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
    ></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "TextEditorComponent",
  data() {
    return {
      content: ''
    };
  },
  methods:{
    updateSelectedText(actionCommand){
      document.execCommand(actionCommand);
      this.content = document.getElementById('textEditorContent').innerHTML;
    },
    textEntered(event){
      this.$emit('textEntered', event.target.innerHTML)
    }
  }
};
</script>

<style>
</style>