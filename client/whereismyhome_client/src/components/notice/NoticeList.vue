<script setup>
import { ref, onMounted } from "vue";
import { listNoticeBoardBySearch } from "@/api/notice.js";
import { useAuthStore } from "@/stores/authStore";
import NoticeListItem from "./item/NoticeListItem.vue";

const authStore = useAuthStore();

onMounted(() => {
  getNoticeBoardList();
});

// Data
const noticeList = ref([]);
const searchInput = ref("");

// Function
const getNoticeBoardList = async () => {
  const response = await listNoticeBoardBySearch(searchInput.value);
  noticeList.value = response.data;
  console.log(noticeList.value);
};
</script>

<template>
  <div class="container-fluid">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 text-center">공지사항</h2>
      </div>
      <div class="col-lg-10">
        <div class="row align-self-center mb-2">
          <div
            class="col-md-2 text-start"
            v-show="authStore.loginId === 'admin'"
          >
            <RouterLink :to="{ name: 'NoticeWrite' }"
              ><button type="button" class="btn btn-sm">
                글쓰기
              </button></RouterLink
            >
          </div>
          <div class="col-md-5 offset-5">
            <form class="d-flex">
              <VSelect :selectOption="selectOption" @onKeySelect="changeKey" />
              <div class="input-group input-group-sm ms-1">
                <input
                  type="text"
                  class="form-control"
                  placeholder="검색어..."
                  v-model="searchInput"
                />
                <button
                  class="btn btn-dark"
                  type="button"
                  @click="getNoticeBoardList"
                >
                  검색
                </button>
              </div>
            </form>
          </div>
        </div>
        <table class="table table-hover">
          <thead>
            <tr class="text-center">
              <th scope="col">글번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성자</th>
              <th scope="col">조회수</th>
              <th scope="col">작성일</th>
            </tr>
          </thead>

          <tbody>
            <NoticeListItem
              v-for="b in noticeList"
              :key="b.articleNo"
              :noticeboard="b"
            ></NoticeListItem>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
