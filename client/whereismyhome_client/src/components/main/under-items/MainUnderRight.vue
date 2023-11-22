<script setup>
import { ref, onMounted } from "vue";
import { listNoticeBoard } from "@/api/notice.js";

onMounted(() => {
  getNoticeBoardList();
});

// Data
const noticeList = ref([]);

// Function
const getNoticeBoardList = async () => {
  const response = await listNoticeBoard();
  noticeList.value = response.data;
  console.log(noticeList.value);
};
</script>

<template>
  <div class="right-wrap">
    <div class="right-wrap-title">
      <h2>공지사항</h2>
      <span class="more-content"
        ><RouterLink :to="{ name: 'NoticeList' }">더 보기</RouterLink></span
      >
    </div>
    <table class="article-tb">
      <tbody>
        <tr v-for="article in noticeList">
          <!-- <th scope="col">글번호</th>
              <th scope="col">제목</th>
          {{
            article.subject
          }}
          &nbsp;
          {{
            article.content
          }} -->
          <th scope="col">{{ article.subject }}</th>
          &nbsp;
          <th scope="col">{{ article.content }}</th>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
.right-wrap {
  width: 400px;
  height: 90%;
  margin-top: 30px;
  margin-left: 80px;
}

.right-wrap-title {
  display: flex;
  justify-content: space-between;
  align-items: flex-end; /* 아래 정렬을 위해 사용 */
  padding: 5px;
  border-bottom: 2px solid #9ba8b3;
}

.more-content {
  align-self: flex-end; /* 아래 정렬을 위해 사용 */
}

.more-content a {
  color: #708090;
  align-self: flex-end; /* 아래 정렬을 위해 사용 */
  text-decoration: none;
}

.more-content a:visited {
  color: #708090;
  align-self: flex-end; /* 아래 정렬을 위해 사용 */
  text-decoration: none;
}

.article-tb {
  margin-top: 10px;
  margin-left: 10px;
  border-collapse: separate;
  border-spacing: 0 15px;
}
</style>
