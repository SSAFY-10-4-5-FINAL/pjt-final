export default [
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
];
