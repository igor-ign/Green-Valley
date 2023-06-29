import axios from 'axios'
import { API_BASE_URL } from '../../app-constants'

export function useHouses() {

    function getHouses(params) {
        return axios.get(`${API_BASE_URL}/api/houses`, params)
    }

    return {
        getHouses
    }
}