export default {
    name: "postJobMixin",
    methods: {
        async createJob(data) {
            this.$axios.post('/public/job/postJob', data)
                .then(response => {
                    if(response.status === 200) {
                        this.$router.push("/");
                    }
                })
                .catch(error => {
                    console.error(error);
                });
        },
        async uploadFile(data) {
            this.$axios.post('/public/job/images', data)
                .then(response => {
                    if(response.status === 200) {
                        console.log("File uploaded successfully");
                    }else{
                        console.log("Error uploading file");
                    }
                })
                .catch(error => {
                    console.error("Error uploading file",error);
                });
        },
    }
};