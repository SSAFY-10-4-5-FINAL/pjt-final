import Vue from "vue";
import Router from "vue-router";
import nav from "./layouts/nav";

Vue.use(Router);

export default new Router({
  routes: [...nav],
});
