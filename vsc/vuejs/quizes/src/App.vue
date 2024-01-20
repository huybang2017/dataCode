<script setup>
import data from "./data/quizes.json";
import { ref, watch } from "vue";
import Card from "./components/Card.vue";
const quizes = ref(data);
const search = ref("");

watch(search, () => {
  if (search.value) {
    quizes.value = data.filter((ele) =>
      ele.name.toLowerCase().includes(search.value.toLowerCase())
    );
  } else {
    quizes.value = data;
  }
});
</script>
<template>
  <div class="container">
    <header>
      <h1>Quizes</h1>
      <input v-model.trim="search" type="text" placeholder="Search ..." />
      {{ search }}
    </header>
    <div class="options-container">
      <Card v-for="quize in quizes" :key="quize.id" :quize="quize" />
    </div>
  </div>
</template>
<style scoped>
body {
  margin: 0;
  padding: 0;
}
.container {
  max-width: 1000px;
  margin: 0 auto;
}
header {
  margin-bottom: 10px;
  margin-top: 30px;
  display: flex;
  align-items: center;
}
header h1 {
  font-weight: bold;
  margin-right: 30px;
}
header input {
  border: none;
  background-color: rgb(128, 128, 128, 0.1);
  padding: 10px;
  border-radius: 5px;
}
.options-container {
  display: flex;
  flex-wrap: wrap;
  margin-top: 40px;
}
</style>
