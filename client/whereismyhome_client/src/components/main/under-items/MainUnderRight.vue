<script setup>
import { ref } from "vue";

const testArticles = ref([
  {
    title: "[공지]test1",
  },
  {
    title: "[공지]test2",
  },
  {
    title: "[공지]test3",
  },
  {
    title: "[공지]test4",
  },
  {
    title: "[공지]test5",
  },
]);
</script>

<template>
  <div class="right-wrap">
    <div class="right-wrap-title">
      <h2>공지사항</h2>
      <span class="more-content"><a href="/apart">더 보기</a></span>
    </div>
    <table class="article-tb">
      <tbody>
        <tr v-for="article in testArticles">
          {{
            article.title
          }}
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
