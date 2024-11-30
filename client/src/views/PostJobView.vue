<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <form
        class="bg-white p-6 rounded-lg shadow-x3 w-full max-w-screen-xl text-left"
    >
      <h2 class="text-2xl font-bold mb-6">Tell us about the job position</h2>
      <div class="mb-4">
        <div class="flex flex-row">
          <label for="jobTitle" class="block text-gray-700 font-bold mb-2"
          >Job Title</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <input
            type="text"
            id="jobTitle"
            v-model="jobTitle"
            v-on:blur="blurDetected"
            class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
            placeholder='Example: "Senior Software Engineer".   Job Titles must describe one position.'
        />
        <div
            v-if="jobTitleError"
            class="text-red-500 text-sm pt-2 font-semibold"
        >
          Job Title is required
        </div>
      </div>

      <div class="mb-4">
        <div class="flex flex-row">
          <label for="category" class="block text-gray-700 font-bold mb-2"
          >Category</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <job-category-dropdown @categorySelected="categorySelected"/>
        <div
            v-if="categoryError"
            class="text-red-500 text-sm pt-2 font-semibold"
        >
          Category is required
        </div>
      </div>

      <div class="mb-4">
        <div class="flex flex-row">
          <label for="workLocation" class="block text-gray-700 font-bold mb-2"
          >Work Location</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <work-location @changeWorkLocation="updateWorkLocation"/>
        <div
            v-if="workLocationError"
            class="text-red-500 text-sm pt-2 font-semibold"
        >
          Work location is required
        </div>
      </div>

      <div class="mb-4">
        <div class="flex flex-row">
          <label for="jobType" class="block text-gray-700 font-bold mb-2"
          >Job Type</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <job-type @changeJobType="updateJobType"/>
        <div
            v-if="jobTypeError"
            class="text-red-500 text-sm pt-2 font-semibold"
        >
          Job Type is required
        </div>
      </div>

      <div class="mb-4">
        <div class="flex flex-row">
          <label for="salaryRange" class="block text-gray-700 font-bold mb-2"
          >Salary Range</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <input
            type="text"
            id="salaryRange"
            v-model="salaryRange"
            v-on:blur="blurDetected"
            class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
            placeholder='Salary range for this position'
        />
        <div
            v-if="salaryRangeError"
            class="text-red-500 text-sm pt-2 font-semibold"
        >
          Salary range is required
        </div>
      </div>

      <div class="mb-4">
        <div class="flex flex-row">
          <label for="jobDescription" class="block text-gray-700 font-bold mb-2"
          >Job Description</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <text-editor-component @textEntered="textEnteredJobDescription"/>
        <div
            v-if="jobDescriptionError"
            class="text-red-500 text-sm pt-2 font-semibold"
        >
          Job description is required
        </div>
      </div>

      <h2 class="text-2xl font-bold mb-6">Tell Us Your Company Details</h2>
      <div class="mb-4">
        <div class="flex flex-row">
          <label for="companyName" class="block text-gray-700 font-bold mb-2"
          >Company Name</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <input
            type="text"
            id="companyName"
            v-model="companyName"
            v-on:blur="blurDetected"
            class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
            placeholder="Your company name or organization name"
        />
        <div
            v-if="companyNameError"
            class="text-red-500 text-sm pt-2 font-semibold"
        >
          Company Name is required
        </div>
      </div>

      <div class="mb-4 flex space-x-4">
        <div class="grow">
          <div class="flex flex-row">
            <label
                for="companyAddress1"
                class="block text-gray-700 font-bold mb-2"
            >HQ Address</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <input
              type="text"
              id="companyAddress1"
              v-model="companyAddress1"
              v-on:blur="blurDetected"
              class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
              placeholder="HQ primary address"
          />
          <div
              v-if="companyAddress1Error"
              class="text-red-500 text-sm pt-2 font-semibold"
          >
            HQ Address is required
          </div>
        </div>

        <div class="grow">
          <div class="flex flex-row">
            <label
                for="companyAddress2"
                class="block text-gray-700 font-bold mb-2"
            >HQ Address 2</label
            >
          </div>
          <input
              type="text"
              id="companyAddress2"
              v-model="companyAddress2"
              class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
              placeholder="HQ secondary address, if any"
          />
        </div>
      </div>

      <div class="mb-4 flex space-x-4">
        <div class="grow">
          <div class="flex flex-row">
            <label
                for="companyWebsite"
                class="block text-gray-700 font-bold mb-2"
            >Website URL</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <input
              type="text"
              id="companyWebsite"
              v-model="companyWebsite"
              v-on:blur="blurDetected"
              class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
              placeholder="Your company's website URL"
          />
          <div
              v-if="companyWebsiteError"
              class="text-red-500 text-sm pt-2 font-semibold"
          >
            Website URL is required and must be valid
          </div>
        </div>

        <div class="grow">
          <div class="flex flex-row">
            <label for="companyEmail" class="block text-gray-700 font-bold mb-2"
            >Email</label
            >
            <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
          </div>
          <input
              type="text"
              id="companyEmail"
              v-model="companyEmail"
              v-on:blur="blurDetected"
              class="bg-gray-200 h-16 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-pink-400"
              placeholder="We will send the confirmation here"
          />
          <div
              v-if="companyEmailError"
              class="text-red-500 text-sm pt-2 font-semibold"
          >
            Email is required and must be valid
          </div>
        </div>
      </div>

      <div class="mb-4">
        <div class="flex flex-row">
          <label for="jobType" class="block text-gray-700 font-bold mb-2"
          >Logo</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <div class="space-y-8 font-[sans-serif] max-w-md">
          <input
              type="file"
              id="resume"
              ref="uploadImage"
              @change="onImageUpload()"
              class="w-full text-gray-500 font-medium text-sm bg-gray-100 file:cursor-pointer cursor-pointer file:border-0 file:py-2 file:px-4 file:mr-4 file:bg-gray-800 file:hover:bg-gray-700 file:text-white rounded"
          />
        </div>
      </div>

      <div class="mb-4">
        <div class="flex flex-row">
          <label
              for="companyDescription"
              class="block text-gray-700 font-bold mb-2"
          >Company Description</label
          >
          <div class="w-2 h-2 bg-red-500 rounded-full ml-2 mt-2"></div>
        </div>
        <text-editor-component @textEntered="textEnteredCompanyDescription"/>
        <div
            v-if="companyDescriptionError"
            class="text-red-500 text-sm pt-2 font-semibold"
        >
          Company Description is required
        </div>
      </div>

      <div class="flex items-center justify-between">
        <button
            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            type="button"
            @click="postJob()"
        >
          Submit
        </button>
      </div>

    </form>
  </div>
</template>

<script>
import JobCategoryDropdown from "../components/JobCategoryDropdown.vue";
import JobType from "../components/JobType.vue";
import TextEditorComponent from "../components/TextEditorComponent.vue";
import WorkLocation from "../components/WorkLocation.vue";
import postJobMixin from "@/mixins/postJobMixin";

export default {
  name: "PostJobView",
  mixins: [postJobMixin],
  components: {
    JobCategoryDropdown,
    WorkLocation,
    JobType,
    TextEditorComponent,
  },
  props: {},
  data() {
    return {
      jobTitle: "",
      jobType: "",
      salaryRange: "",
      companyName: "",
      companyAddress1: "",
      companyAddress2: "",
      companyWebsite: "https://google.com",
      companyEmail: "test@gmail.com",
      jobTitleError: false,
      categoryError: false,
      workLocationError: false,
      jobTypeError: false,
      salaryRangeError: false,
      jobDescriptionError: false,
      companyNameError: false,
      companyAddress1Error: false,
      companyWebsiteError: false,
      companyEmailError: false,
      companyDescriptionError: false,
      hasValidationError: false,
      formData: null,
    };
  },
  mounted() {
  },
  methods: {
    blurDetected(e) {
      if (e && e.target) {
        let elementId = e.target.id;
        if (e.target.value) {
          switch (elementId) {
            case "jobTitle":
              this.jobTitleError = false;
              break;
            case "salaryRange":
              this.salaryRangeError = false;
              break;
            case "companyName":
              this.companyNameError = false;
              break;
            case "companyAddress1":
              this.companyAddress1Error = false;
              break;
            case "companyWebsite":
              this.companyWebsiteError = !this.isUrlValid(e.target.value);
              break;
            case "companyEmail":
              this.companyEmailError = !this.isValidEmail(e.target.value);
              break;
            default:
              console.log("No match element 1:" + elementId);
          }
        } else {
          switch (elementId) {
            case "jobTitle":
              this.jobTitleError = true;
              break;
            case "salaryRange":
              this.salaryRangeError = true;
              break;
            case "companyName":
              this.companyNameError = true;
              break;
            case "companyAddress1":
              this.companyAddress1Error = true;
              break;
            case "companyWebsite":
              this.companyWebsiteError = true;
              break;
            case "companyEmail":
              this.companyEmailError = true;
              break;
            default:
              console.log("No match element 2:" + elementId);
          }
        }
      }
    },
    async postJob() {
      this.validateInput();

      //gather data and proceed with processing
      if (!this.hasValidationError) {
        let data = {
          jobTitle: this.jobTitle,
          salaryRange: this.salaryRange,
          categoryId: this.category,
          workLocation: this.workLocation,
          jobType: this.jobType,
          jobDescription: this.jobDescription,
          companyName: this.companyName,
          companyAddress1: this.companyAddress1,
          companyAddress2: this.companyAddress2,
          companyWebsite: this.companyWebsite,
          companyEmail: this.companyEmail,
          companyDescription: this.companyDescription,
        };
        await this.createJob(data);

        //upload logo
        await this.uploadFile(this.formData);
      }
    },
    validateInput() {
      let validationCount = 0;
      if (!this.jobTitle) {
        this.jobTitleError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.jobTitleError = false;
      if (!this.salaryRange) {
        this.salaryRangeError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.salaryRangeError = false;
      if (!this.category) {
        this.categoryError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.categoryError = false;
      if (!this.workLocation) {
        this.workLocationError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.workLocationError = false;
      if (!this.jobType) {
        this.jobTypeError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.jobTypeError = false;
      if (!this.jobDescription || this.jobDescription === '<br>') {
        this.jobDescriptionError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.jobDescriptionError = false;
      if (!this.companyDescription || this.companyDescription === '<br>') {
        this.companyDescriptionError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.companyDescriptionError = false;
      if (!this.companyName) {
        this.companyNameError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.companyNameError = false;
      if (!this.companyAddress1) {
        this.companyAddress1Error = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.companyAddress1Error = false;
      if (!this.companyWebsite) {
        this.companyWebsiteError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.companyWebsiteError = false;
      if (!this.companyEmail) {
        this.companyEmailError = true;
        this.hasValidationError = true;
        validationCount++;
      } else this.companyEmailError = false;

      if (validationCount === 0) this.hasValidationError = false;

    },
    categorySelected(value) {
      this.category = value;
      this.categoryError = value === '999' || !value;
    },
    updateWorkLocation(value) {
      this.workLocation = value;
      this.workLocationError = (!value);
    },
    updateJobType(value) {
      this.jobType = value;
      this.jobTypeError = (!value);
    },
    textEnteredJobDescription(value) {
      this.jobDescription = value;
      this.jobDescriptionError = value === '<br>' || (!value);
    },
    textEnteredCompanyDescription(value) {
      this.companyDescription = value;
      this.companyDescriptionError = value === '<br>' || (!value);
    },
    onImageUpload() {
      let file = this.$refs.uploadImage.files[0];
      this.formData = new FormData();
      this.formData.append("file", file);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
