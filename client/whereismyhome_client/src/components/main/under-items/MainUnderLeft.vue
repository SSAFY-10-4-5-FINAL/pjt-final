<script setup>
import { ref, onMounted } from "vue";

onMounted(() => {
  let ranNum = Math.floor(Math.random() * imgArr.length);
  imgUrl.value = imgArr[ranNum];
});

const imgArr = [
  "https://landthumb-phinf.pstatic.net/20171109_118/apt_realimage_1510217117636OhXya_JPEG/744e15d68618f3d155dac67f0b5e87e2.JPG?type=m1024",
  "https://landthumb-phinf.pstatic.net/20180410_254/apt_realimage_1523344302806JAWcE_JPEG/9f27cde602fcc26b65fc167e8b434dc3.JPG?type=m1024",
  "https://landthumb-phinf.pstatic.net/20110421_212/land_system_13033841095606DpXX_JPEG/detail_8971_6.jpg?type=m1024",
  "https://landthumb-phinf.pstatic.net/20200720_111/apt_realimage_1595222185360IOk9G_JPEG/3d7bc3053ea96b29437b49b171508ac8.JPG?type=m1024",
  "https://landthumb-phinf.pstatic.net/20211101_56/land_naver_1635730261260cK3TF_JPEG/fb1ca9a338aafef546e2213ea4979d15.JPG?type=m1024",
];

const imgUrl = ref("");
</script>

<template>
  <div class="left-wrap">
    <div class="left-wrap-title"><h2>소개할게요</h2></div>
    <div class="left-wrap-content">
      <img :src="imgUrl" alt="" style="width: 400px; height: 200px" />
    </div>
  </div>
</template>

<style scoped>
.left-wrap {
  width: 400px;
  height: 90%;
  margin-top: 30px;
  margin-right: 80px;
}

.left-wrap-title {
  padding: 5px;
  border-bottom: 2px solid #9ba8b3;
}

.left-wrap-content img {
  margin-top: 10px;
  width: 380px;
}
</style>
