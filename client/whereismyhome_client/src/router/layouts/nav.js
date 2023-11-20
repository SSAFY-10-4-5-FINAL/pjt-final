import ApartRight from "@/router/apart/apart_right";

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
    redirect: "/apart/right/under", // 아파트 페이지의 첫 페이지는 아파트 추천목록임
    children: ApartRight,
  },
];
