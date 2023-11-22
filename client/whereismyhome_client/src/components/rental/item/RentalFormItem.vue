<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import {
  detailRentalArticle,
  writeRentalBoard,
  modifyRentalArticle,
} from "@/api/rental";

const router = useRouter();
const route = useRoute();
const props = defineProps({ mode: String });
const article = ref({
  articleNo: 0,
  userId: "",
  subject: "",
  content: "",
  hit: 0,
  registerTime: "",
});

if (props.mode === "modify") {
  let { articleNo } = route.params;
  const response = await detailRentalArticle(articleNo);
  article.value = response.data;
}

const subjectErrMsg = ref("");
const contentErrMsg = ref("");

watch(
  () => article.value.subject,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 30) {
      subjectErrMsg.value = "제목을 확인해 주세요!!!";
    } else subjectErrMsg.value = "";
  },
  { immediate: true }
);

watch(
  () => article.value.content,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 500) {
      contentErrMsg.value = "내용을 확인해 주세요!!!";
    } else contentErrMsg.value = "";
  },
  { immediate: true }
);

function onSubmit() {
  if (subjectErrMsg.value) {
    alert(subjectErrMsg.value);
  } else if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    props.mode === "regist" ? writeRentalArticle() : updateRentalArticle();
  }
}

const writeRentalArticle = async () => {
  console.log(article.value);
  const response = await writeRentalBoard(article.value);
  if (response.status == 201) {
    let msg = "단기양도 게시판 글 작성이 완료되었습니다.";
    alert(msg);
    router.push({ name: "RentalList" });
  }
};
const updateRentalArticle = async () => {
  let { articleNo } = route.params;
  const response = await modifyRentalArticle(articleNo, article.value);
  if (response.status == 200) {
    let msg = "단기양도 게시판 글 수정이 완료되었습니다.";
    alert(msg);
    router.push({ name: "RentalList" });
  }
};
</script>

<template>
  <form @submit.prevent="onSubmit">
    <div class="mb-3" v-if="mode === 'regist'">
      <label for="userid" class="form-label">작성자 ID : </label>
      <input
        type="text"
        class="form-control"
        v-model="article.userId"
        placeholder="작성자ID..." />
    </div>
    <div class="mb-3">
      <label for="subject" class="form-label">제목 : </label>
      <input
        type="text"
        class="form-control"
        v-model="article.subject"
        placeholder="제목..." />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용 : </label>
      <textarea
        class="form-control"
        v-model="article.content"
        rows="10"></textarea>
    </div>
    <div class="col-auto text-center">
      <button type="submit" class="btn mb-3" style="color: black">확인</button>
      <button type="button" class="btn mb-3 ms-1">
        <RouterLink
          :to="{ name: 'RentalList' }"
          style="text-decoration: none; color: black"
          >목록으로이동...</RouterLink
        >
      </button>
    </div>
  </form>
</template>

<style scoped></style>
