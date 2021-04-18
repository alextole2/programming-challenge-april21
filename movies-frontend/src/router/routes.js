
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
      { path: 'file', component: () => import('pages/FileUpload.vue') },
      { path: 'movies', component: () => import('pages/Movies.vue') },
      { path: 'ratings', component: () => import('pages/Ratings.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
