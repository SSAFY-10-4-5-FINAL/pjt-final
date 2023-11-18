import Vue from "vue";
import Router from "vue-router";
import layouts from "./layouts";

Vue.use(Router);

export default new Router({
  routes: [...layouts],
});
