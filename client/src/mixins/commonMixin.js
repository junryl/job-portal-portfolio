import store from '../store';
import jobListLocal from '../data/jobs.json';

export default {
    name: "commonMixin",
    methods: {
        async loadJobs() {
            if (store.categoryFilterId) {
                store.jobs = jobListLocal.filter((job) => job.categoryId === store.categoryFilterId)
            } else {
                this.$axios.get('/public/job/list')
                    .then(response => {
                        store.jobs = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                    });
                //store.jobs = jobListLocal //pull all jobs
            }
        },

        isValidEmail(email) {
            return String(email)
                .toLowerCase()
                .match(
                    /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
                );
        },
        isValidMobileNumber(phone) {
            return String(phone)
                .toLowerCase()
                .match(/((^(\+)(\d){12}$)|(^\d{11}$))/);
        },
        isInValidNumber(string) {
            string = string.replaceAll(",", "");
            return isNaN(string);
        },
        isUrlValid(urlString) {
            var urlPattern = new RegExp('^(https?:\\/\\/)?' + // validate protocol
                '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.)+[a-z]{2,}|' + // validate domain name
                '((\\d{1,3}\\.){3}\\d{1,3}))' + // validate OR ip (v4) address
                '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*' + // validate port and path
                '(\\?[;&a-z\\d%_.~+=-]*)?' + // validate query string
                '(\\#[-a-z\\d_]*)?$', 'i'); // validate fragment locator
            return !!urlPattern.test(urlString);
        },
    }
};