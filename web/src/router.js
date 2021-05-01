import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/components/Home'
import Survey from '@/components/Survey'
import SurveyResults from '@/components/SurveyResults'

const routerHistory = createWebHistory()
const router = createRouter({
    history: routerHistory,
    routes: [
        {
            path: "/",
            alias: "/home",
            name: "home",
            component: Home

        },
        {
            path: "/survey",
            name: "survey",
            component: Survey
        },
        {
            path: "/surveyResults",
            name: "surveyResults",
            component: SurveyResults
        }
    ]
})

export default router