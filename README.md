# Admin Portal
[![admin-ui build upon a push](https://github.com/mosip/admin-ui/actions/workflows/push-trigger.yml/badge.svg?branch=master)](https://github.com/mosip/admin-ui/actions/workflows/push-trigger.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?branch=master)](https://sonarcloud.io/dashboard?branch=master)

## Overview
An admin application is a web-based application used by a privileged group of administrative personnel to manage various master data sets. The various resources that an Admin can manage are:

* Center (Registration centers)
* Device
* Machine
* Users (Admin, Registration staff)

Along with the resource and data management, the admin can generate master keys, check registration status, retrieve lost RID, and resume processing of paused packets. To start using the Admin portal, an admin user must be assigned to a zone.
 Refer [overview and portal user guide](https://docs.mosip.io/1.2.0/modules/administration/admin-portal-user-guide).

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.0.3.

### Local Setup (for Development or Contribution)
The project can be set up in two ways:

1. [Local Setup (for Development or Contribution)](#local-setup-for-development-or-contribution)
2. [Local Setup with Docker (Easy Setup for Demos)](#local-setup-with-docker-easy-setup-for-demos)

### Local Setup (for Development or Contribution)
## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

### Local Setup with Docker (Easy Setup for Demos)
#### Build Docker Images Locally

Recommended for contributors or developers who want to modify or build the services from source.

1. Clone and build the project:

```text
git clone <repo-url>
```
```text
cd admin-ui
```
2. Navigate to each service directory and build the Docker image:
```text
cd admin-ui/<service-directory>
```
```text
docker build -t <service-name> .
```
#### Running the Services

Start each service using Docker:

```text
docker run -d -p <port>:<port> --name <service-name> <service-name>
```
#### Verify Installation

Check that all containers are running:

```text
docker ps
```
Access the services at `http://localhost:<port>` using the port mappings listed above.

## Deployment
### Kubernetes
### Pre-requisites
* Set KUBECONFIG variable to point to existing K8 cluster kubeconfig file:
    * ```
      export KUBECONFIG=~/.kube/<my-cluster.config>
      ```
### Install
  ```
    $ cd deploy
    $ ./install.sh
   ```
### Delete
  ```
    $ cd deploy
    $ ./delete.sh
   ```
### Restart
  ```
    $ cd deploy
    $ ./restart.sh
   ```
### Product Documentation
To learn more about admin services from a functional perspective and use case scenarios, refer to our main documentation: [Click here](https://docs.mosip.io/1.2.0/id-lifecycle-management/support-systems/administration).

## Contribution & Community

* To learn how you can contribute code to this application, [click here](https://docs.mosip.io/1.2.0/community/code-contributions).

* If you have questions or encounter issues, visit the [MOSIP Community](https://community.mosip.io/) for support.
* For any GitHub issues: [Report here](https://github.com/mosip/admin-ui/issues)

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.0.3.

## License
This project is licensed under the terms of [Mozilla Public License 2.0](LICENSE)