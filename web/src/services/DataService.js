import http from "../http-common";

class DataService {
    getAll() {
        return http.get("/surveyResults");
    }

    get(id) {
        return http.get(`/surveyResults/${id}`);
    }

    create(data) {
        return http.post("/survey", data);
    }

    update(id, data) {
        return http.put(`/surveyResults/${id}`, data);
    }

    delete(id) {
        return http.delete(`/surveyResults/${id}`);
    }
}

export default new DataService();