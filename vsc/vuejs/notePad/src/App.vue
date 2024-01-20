<script setup>
import { ref } from "vue";
const showModal = ref(false);
const newNote = ref("");
const errorMessage = ref("");
const listNote = ref([]);

function getRandomColor() {
  const letters = "0123456789ABCDEF";
  let color = "#";
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

const addNote = () => {
  if (newNote.value.length < 10) {
    return (errorMessage.value = "Nhập nhiều hơn 10 ký tự");
  }
  listNote.value.push({
    id: Math.floor(Math.random() * 1000000),
    note: newNote.value,
    date: new Date(),
    backGroundColor: getRandomColor(),
  });
  showModal.value = !showModal.value;
  newNote.value = "";
  errorMessage.value = "";
};
</script>
<template>
  <main>
    <div v-if="showModal" class="overlay">
      <div class="modal">
        <textarea
          v-model.trim="newNote"
          name=""
          id=""
          cols="30"
          rows="10"
        ></textarea>
        <p v-if="errorMessage" style="color: red" class="error">
          {{ errorMessage }}
        </p>
        <button @click="addNote">Add note</button>
        <button @click="showModal = !showModal" class="close">close</button>
      </div>
    </div>
    <div class="container">
      <header>
        <h1>NOTES</h1>
        <button @click="showModal = !showModal" class="button" type="button">
          <span class="button__text">Add Item</span>
          <span class="button__icon"
            ><svg
              class="svg"
              fill="none"
              height="24"
              stroke="currentColor"
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              viewBox="0 0 24 24"
              width="24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <line x1="12" x2="12" y1="5" y2="19"></line>
              <line x1="5" x2="19" y1="12" y2="12"></line></svg
          ></span>
        </button>
      </header>
      <div class="cards-container">
        <div
          v-for="item in listNote"
          :key="item.id"
          class="card"
          :style="{ backgroundColor: item.backGroundColor }"
        >
          <p class="main-text">{{ item.note }}</p>
          <p class="date">{{ item.date.toLocaleString() }}</p>
        </div>
      </div>
    </div>
  </main>
</template>
<style>
body {
  padding: 0;
  margin: 0;
}

.container {
  max-width: 1000px;
  padding: 10px;
  margin: 0 auto;
}

header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

h1 {
  font-weight: bold;
  margin-bottom: 25px;
  font-size: 75px;
}

.button {
  --main-focus: #2d8cf0;
  --font-color: #323232;
  --bg-color-sub: #dedede;
  --bg-color: #eee;
  --main-color: #323232;
  position: relative;
  width: 150px;
  height: 40px;
  cursor: palphaointer;
  display: flex;
  align-items: center;
  border: 2px solid var(--main-color);
  box-shadow: 4px 4px var(--main-color);
  background-color: var(--bg-color);
  border-radius: 10px;
  overflow: hidden;
}

.button,
.button__icon,
.button__text {
  transition: all 0.3s;
  font-size: 17px;
}

.button .button__text {
  transform: translateX(22px);
  color: var(--font-color);
  font-weight: 600;
}

.button .button__icon {
  position: absolute;
  transform: translateX(109px);
  height: 100%;
  width: 39px;
  background-color: var(--bg-color-sub);
  display: flex;
  align-items: center;
  justify-content: center;
}

.button .svg {
  width: 20px;
  fill: var(--main-color);
}

.button:hover {
  background: var(--bg-color);
}

.button:hover .button__text {
  color: transparent;
}

.button:hover .button__icon {
  width: 148px;
  transform: translateX(0);
}

.button:active {
  transform: translate(3px, 3px);
  box-shadow: 0px 0px var(--main-color);
}

.cards-container {
  display: flex;
  flex-wrap: wrap;
}

.card {
  width: 225px;
  height: 225px;
  background-color: rgb(214, 237, 44);
  padding: 10px;
  border-radius: 15px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin-right: 20px;
  margin-bottom: 20px;
}

.date {
  text-align: right;
  font-size: 12.5px;
  font-weight: bold;
}

.overlay {
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.77);
  z-index: 10;
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal {
  width: 750px;
  background-color: white;
  border-radius: 10px;
  padding: 30px;
  position: relative;
  display: flex;
  flex-direction: column;
}

.modal button {
  padding: 10px 20px;
  font-size: 20px;
  width: 100%;
  background-color: blueviolet;
  border: none;
  color: white;
  cursor: pointer;

  margin-top: 15px;
}

.modal .close {
  background-color: rgb(193, 15, 15);
}
</style>
