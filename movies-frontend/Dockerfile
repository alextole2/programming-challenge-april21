# Develop Stage
FROM node:13.14-alpine as develop-stage
WORKDIR /movies-frontend
COPY package*.json ./
RUN yarn global add @quasar/cli
COPY . .

# Build stage
FROM develop-stage as build-stage
RUN yarn
RUN quasar build

# Production stage
FROM nginx:1.17.5-alpine as production-stage
COPY --from=build-stage /movies-frontend/dist/spa /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]