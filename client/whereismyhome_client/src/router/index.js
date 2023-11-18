import { createRouter, createWebHistory } from "vue-router";
import navRoutes from "@/router/layouts/nav";
import apart from "@/router/apart/apart";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // 각 router 파일에서 배열로 내보낸 routes들을 ...을 통해 iterable로 인식, 여기에서 읽어들이는 형태
  routes: [...navRoutes, ...apart],
});

export default router;
