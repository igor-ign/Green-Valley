import axios from 'axios'

export function useLogin() {

    function login(params) {
        const response = axios.get('', params)

        return response.data
    }

    return {
        login
    }
}