module.exports = { getAppName, getAppDescription, getAppVersion, getAppEnvironmentFrom }

function getAppName () {
  return 'Movie Lens app'
}

function getAppDescription () {
  return 'Movie Lens Programming Challenge'
}

function getAppVersion () {
  return '1.0.0'
}

function getAppEnvironmentByPort (port) {
  const environment = {
    appPort: JSON.stringify(port),
    appName: JSON.stringify(getAppName()),
    appVersion: JSON.stringify(getAppVersion())
  }
  return environment
}

function getAppEnvironmentFrom (ctx) {
  const environment = ctx.dev
    ? getAppEnvironmentByPort('3000')
    : getAppEnvironmentByPort('81')
  return environment
}
