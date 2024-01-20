<script setup>
import { defineProps } from "vue";
const { quize } = defineProps(["quize"]);
</script>
<template>
  <div class="card">
    <img :src="quize.img" alt="#" />
    <div class="card-text">
      <h2>{{ quize.name }}</h2>
      <p>{{ quize.questions.length }} questions</p>
    </div>
  </div>
</template>
<style scoped>
/* CARD */
.card {
  width: 300px;
  overflow: hidden;
  border-radius: 2%;
  box-shadow: 1px 1px 10px rgb(0, 0, 0, 0.1);
  margin-bottom: 35px;
  margin-right: 20px;
  cursor: pointer;
}
.card img {
  width: 100%;
  height: 190px;
  margin: 0;
}
.card .card-text {
  padding: 0 10px;
}
.card .card-text h2 {
  font-weight: bold;
}
</style>
