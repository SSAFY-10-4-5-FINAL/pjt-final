import {
  createRouter,
  createWebHashHistory,
  createWebHistory,
} from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "MainView",
      component: () => import("@/views/MainView.vue"),
    },
    {
      path: "/apart",
      name: "ApartView",
      component: () => import("@/views/ApartView.vue"),
    },
  ],
});

export default router;
