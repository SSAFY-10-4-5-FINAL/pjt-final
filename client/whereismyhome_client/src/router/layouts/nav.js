import ApartRight from "@/router/apart/apart_right";
import Community from "@/router/community/community";
import Rental from "@/router/rental/rental";
import Notice from "@/router/notice/notice";

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
  {
    path: "/community",
    name: "CommunityView",
    component: () => import("@/views/CommunityView.vue"),
    redirect: "/community/list",
    children: Community,
  },
  {
    path: "/rental",
    name: "RentalView",
    component: () => import("@/views/RentalView.vue"),
    redirect: "/rental/list",
    children: Rental,
  },
  {
    path: "/notice",
    name: "NoticeView",
    component: () => import("@/views/NoticeView.vue"),
    redirect: "/notice/list",
    children: Notice,
  },
  // < ----------- 회원가입, 로그인 ----------- >
  {
    path: "/join",
    name: "JoinView",
    component: () => import("@/views/JoinView.vue"),
  },
  {
    path: "/login",
    name: "LoginView",
    component: () => import("@/views/LoginView.vue"),
  },
];
