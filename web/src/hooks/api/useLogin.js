import axios from 'axios'
import { API_BASE_URL } from '../../app-constants'

export function useLogin() {

    function login(params) {
        return axios.post(`${API_BASE_URL}/admin/user/login`, params)
    }

    return {
        login
    }
}