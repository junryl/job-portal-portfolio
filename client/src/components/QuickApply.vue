<template>
  <div>
    <div class="h1 px-8 pt-6 text-lg"><strong>Quick Apply</strong></div>
    <div class="w-full">
      <form
        class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4"
        id="quickApplyForm"
      >
        <div class="mb-4">
          <div class="flex flex-row">
            <label for="name" class="block text-gray-700 font-bold mb-2"
              >Name</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <input
            type="text"
            id="applicantName"
            v-model="applicantName"
            v-on:blur="blurDetected"
            class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
            placeholder="Name"
          />
          <div
            v-if="applicantNameError"
            class="text-red-500 text-sm pt-2 font-semibold"
          >
            Name is required
          </div>
        </div>

        <div class="mb-4">
          <div class="flex flex-row">
            <label
              for="emailAddress1"
              class="block text-gray-700 font-bold mb-2"
              >Email</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <input
            type="text"
            id="emailAddress1"
            v-model="emailAddress1"
            v-on:blur="blurDetected"
            class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
            placeholder="Email Address"
          />
          <div
            v-if="emailAddress1Error"
            class="text-red-500 text-sm pt-2 font-semibold"
          >
            Email is required OR Email is invalid
          </div>
        </div>

        <div class="mb-4">
          <div class="flex flex-row">
            <label
              for="emailAddress2"
              class="block text-gray-700 font-bold mb-2"
              >Confirm Email</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <input
            type="text"
            v-model="emailAddress2"
            v-on:blur="blurDetected"
            id="emailAddress2"
            class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
            placeholder="Confirm Email Address"
          />
          <div
            v-if="emailAddress2Error"
            class="text-red-500 text-sm pt-2 font-semibold"
          >
            Confirm Email is required OR Confirm Email is invalid OR Email and
            Confirm email does not match
          </div>
        </div>

        <div class="mb-4">
          <div class="flex flex-row">
            <label for="mobileNumber" class="block text-gray-700 font-bold mb-2"
              >Mobile Number</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <input
            type="text"
            id="mobileNumber"
            v-model="mobileNumber"
            v-on:blur="blurDetected"
            class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
            placeholder="Mobile Number"
          />
          <div
            v-if="mobileNumberError"
            class="text-red-500 text-sm pt-2 font-semibold"
          >
            Mobile Number is required OR Mobile Number is invalid
          </div>
        </div>

        <div class="mb-4">
          <div class="flex flex-row">
            <label for="gender" class="block text-gray-700 font-bold mb-2"
              >Gender</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <gender-component @changeGender="updateGender" />
        </div>

        <div class="mb-4">
          <div class="flex flex-row">
            <label
              for="expectedSalary"
              class="block text-gray-700 font-bold mb-2"
              >Expected Salary</label
            >
          </div>
          <input
            type="text"
            id="expectedSalary"
            v-model="expectedSalary"
            v-on:blur="blurDetected"
            class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
            placeholder="Expected Salary"
          />
          <div
            v-if="expectedSalaryError"
            class="text-red-500 text-sm pt-2 font-semibold"
          >
            Expected salary is invalid
          </div>
        </div>

        <div class="mb-4">
          <div class="flex flex-row">
            <label for="coverLetter" class="block text-gray-700 font-bold mb-2"
              >Cover Letter</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <textarea
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-1 outline-pink-300 focus:shadow-outline"
            id="coverLetter"
            v-model="coverLetter"
            v-on:blur="blurDetected"
            rows="4"
            placeholder=""
          />
          <div
            v-if="coverLetterError"
            class="text-red-500 text-sm pt-2 font-semibold"
          >
            Cover letter is required
          </div>
        </div>

        <div class="mb-4">
          <label
            class="block text-gray-700 text-sm font-bold mb-2"
            for="resume"
          >
            Resume:
          </label>
          <div class="space-y-8 font-[sans-serif] max-w-md">
            <input
              type="file"
              id="resume"
              class="w-full text-gray-500 font-medium text-sm bg-gray-100 file:cursor-pointer cursor-pointer file:border-0 file:py-2 file:px-4 file:mr-4 file:bg-gray-800 file:hover:bg-gray-700 file:text-white rounded"
            />
          </div>
        </div>

        <div class="flex items-center justify-between">
          <button
            v-if="!hasValidationErrorOrEmpty"
            id="sendApplication"
            class="bg-pink-500 hover:bg-pink-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            type="button"
            @click="processApplication()"
          >
            Send Application
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import GenderComponent from "./GenderComponent.vue";
import commonMixin from "../mixins/commonMixin";

export default {
  components: { GenderComponent },
  name: "QuickApply",
  mixins: [commonMixin],
  props: {},
  data() {
    return {
      applicantName: "",
      emailAddress1: "",
      emailAddress2: "",
      mobileNumber: "",
      expectedSalary: "",
      coverLetter: "",
      applicantNameError: false,
      emailAddress1Error: false,
      emailAddress2Error: false,
      mobileNumberError: false,
      coverLetterError: false,
      expectedSalaryError: false,
      selectedGender: null,
    };
  },
  mounted() {},
  methods: {
    blurDetected(e) {
      if (e && e.target) {
        let elementId = e.target.id;
        if (e.target.value) {
          switch (elementId) {
            case "applicantName":
              this.applicantNameError = false;
              break;
            case "emailAddress1":
              this.emailAddress1Error = !this.isValidEmail(e.target.value);
              break;
            case "emailAddress2":
              if (!this.isValidEmail(e.target.value)) {
                this.emailAddress2Error = true;
              }
              this.emailAddress2Error = !!(this.emailAddress1 &&
                  this.emailAddress2 &&
                  this.emailAddress1 !== this.emailAddress2);
              break;
            case "mobileNumber":
              this.mobileNumberError = !this.isValidMobileNumber(e.target.value);
              break;
            case "coverLetter":
              this.coverLetterError = false;
              break;
            case "expectedSalary":
              this.expectedSalaryError = this.isInValidNumber(e.target.value);
              break;
            default:
              console.log("No match element 1:" + elementId);
          }
        } else {
          switch (elementId) {
            case "applicantName":
              this.applicantNameError = true;
              break;
            case "emailAddress1":
              this.emailAddress1Error = true;
              break;
            case "emailAddress2":
              this.emailAddress2Error = true;
              break;
            case "mobileNumber":
              this.mobileNumberError = true;
              break;
            case "coverLetter":
              this.coverLetterError = true;
              break;
            case "expectedSalary":
              this.expectedSalaryError = false;
              break;
            default:
              console.log("No match element 2:" + elementId);
          }
        }
      }
    },
    updateGender(value) {
      this.selectedGender = value;
    },
    processApplication() {
      //gather data and proceed with processing
      let data = {
        applicantName: this.applicantName,
        emailAddress1: this.emailAddress1,
        emailAddress2: this.emailAddress2,
        mobileNumber: this.mobileNumber,
        gender: this.selectedGender,
        expectedSalary: this.expectedSalary,
        coverLetter: this.coverLetter,
      };
      console.log("final data for processing", data);
    },
  },
  computed: {
    hasValidationErrorOrEmpty: function () {
      return (
        this.applicantNameError === true ||
        !this.applicantName ||
        this.emailAddress1Error === true ||
        !this.emailAddress1 ||
        this.emailAddress2Error === true ||
        !this.emailAddress2 ||
        this.mobileNumberError === true ||
        !this.mobileNumber ||
        this.coverLetterError === true ||
        !this.coverLetter ||
        this.expectedSalaryError === true ||
        !this.selectedGender
      );
    },
  },
};
</script>
<style scoped>
</style>
