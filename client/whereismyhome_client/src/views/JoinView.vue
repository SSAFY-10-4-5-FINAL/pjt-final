<script setup>
import TheFooter from "@/components/layouts/TheFooter.vue";
</script>

<template>
  <div class="join-view-wrap">
    <div class="join-form-wrap">
      <form class="join-form">
        <div id="join-text-area">
          <div class="form-group row">
            <div class="col-sm-2"></div>
            <!-- 중간 정렬을 위한 추가된 div -->
            <div class="col-sm-8">
              <!-- 수정된 부분 -->
              <input type="text" class="form-control" placeholder="아이디" />
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
              <input
                type="password"
                class="form-control"
                id="inputPassword3"
                placeholder="비밀번호" />
            </div>
          </div>
          <div class="form-group row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
              <input
                type="password"
                class="form-control"
                id="inputPassword3"
                placeholder="닉네임" />
            </div>
          </div>
        </div>
        <fieldset class="form-group">
          <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
              <legend class="col-form-label"><h6>프로필 공개 여부</h6></legend>
            </div>
          </div>
          <div class="row justify-content-center">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="gridRadios"
                  id="gridRadios1"
                  value="option1"
                  checked />
                <label class="form-check-label" for="gridRadios1"> 동의 </label>
              </div>
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="radio"
                  name="gridRadios"
                  id="gridRadios2"
                  value="option2" />
                <label class="form-check-label" for="gridRadios2"> 비동의 </label>
              </div>
            </div>
          </div>
        </fieldset>
        <div class="form-group row">
          <div class="col-sm-2"></div>
          <div class="col-sm-8">
            <button type="submit" class="btn btn-primary">Join</button>
          </div>
        </div>
      </form>
    </div>
  </div>
  <TheFooter />
</template>

<style scoped>
.join-view-wrap {
  padding: 200px;
}
.join-form-wrap {
  border: 2px solid black;
  display: flex;
  padding: 50px;
  justify-content: center; /* 수평 가운데 정렬 */
}

.join-form {
  width: 100%;
}

.join-form .row {
  margin: 20px;
}

.join-form #join-text-area input {
  height: 60px;
}
</style>
