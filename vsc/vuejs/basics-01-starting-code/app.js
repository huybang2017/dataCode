const app = Vue.createApp({
  data() {
    return {
      courseGoalA: "finish the course and learn Vue",
      courseGoalB: "master Vue and build amazing apps",
      vueLink: "https://vuejs.org/",
    };
  },
  methods: {
    outputGoals() {
      const ramdomNumber = Math.random();
      if (ramdomNumber < 0.5) {
        return this.courseGoalA;
      } else {
        return this.courseGoalB;
      }
    },
  },
});

app.mount("#user-goal");
