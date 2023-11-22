<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { writeBoard } from "@/api/community";

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
  // event.preventDefault();
  console.log(subjectErrMsg);
  console.log(contentErrMsg);

  if (subjectErrMsg.value) {
    alert(subjectErrMsg.value);
  } else if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    // props.mode === "regist" ? writeArticle() : updateArticle();
    writeArticle();
  }
}

const writeArticle = async () => {
  console.log(article.value);
  const response = await writeBoard(article.value);
  if (response.status == 201) {
    let msg = "글 작성이 완료되었습니다.";
    alert(msg);
    router.push({ name: "CommunityList" });
  }
};
</script>

<template>
  <form @submit.prevent="onSubmit">
    <div class="mb-3">
      <label for="userid" class="form-label">작성자 ID : </label>
      <input type="text" class="form-control" v-model="article.userId" placeholder="작성자ID..." />
    </div>
    <div class="mb-3">
      <label for="subject" class="form-label">제목 : </label>
      <input type="text" class="form-control" v-model="article.subject" placeholder="제목..." />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용 : </label>
      <textarea class="form-control" v-model="article.content" rows="10"></textarea>
    </div>
    <div class="col-auto text-center">
      <button type="submit" class="btn mb-3" style="color: black">확인</button>
      <button type="button" class="btn mb-3 ms-1">
        <RouterLink :to="{ name: 'CommunityList' }" style="text-decoration: none; color: black"
          >목록으로이동...</RouterLink
        >
      </button>
    </div>
  </form>
</template>

<style scoped></style>
