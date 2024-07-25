# MLSecOps - DevSecOps - Awesome

This project is dedicated to curating a comprehensive list of resources, tools, and best practices at the intersection of Machine Learning Security Operations (MLSecOps), and Development Security Operations (DevSecOps). Our goal is to provide a centralized hub for professionals, researchers, and enthusiasts who are passionate about integrating security into the development and deployment of machine learning systems.

## What is MLSecOps?

MLSecOps is an emerging field that focuses on the secure and efficient operation of machine learning models in production environments. It combines the principles of DevSecOps with the unique challenges of machine learning, emphasizing the importance of security, privacy, and compliance throughout the ML lifecycle.

## What is DevSecOps?

DevSecOps extends the traditional DevOps framework by incorporating security practices into the entire software development process. It aims to automate security checks and integrate them seamlessly into the CI/CD pipeline, ensuring that security is a fundamental part of the development workflow.

## Repository Overview

In this repository, you will find:

* Resources: Articles, papers, and tutorials on MLSecOps and DevSecOps.
* Tools: A curated list of open-source tools for securing ML models and development pipelines.
* Best Practices: Guidelines and methodologies for implementing security measures in ML projects.
* Case Studies: Real-world examples of successful MLSecOps and DevSecOps implementations.
* Community: Links to forums, conferences, and groups where you can connect with others interested in these fields.

# Proposed Pipeline

### 💥 MLSecOps Pipeline

![image](https://github.com/user-attachments/assets/522921f1-0f7d-469f-a2e4-fdacbc219ac8)

### 💥 DevSecOps Pipeline

![image](https://github.com/user-attachments/assets/7e47e257-3b2f-4bd4-8e08-bf04d6a13cd5)

## Research papers List

## Community Resources

- [OWASP LLMSVS](https://owasp.org/www-project-llm-verification-standard/)
- [OWASP Top 10 for Large Language Model Applications](https://owasp.org/www-project-top-10-for-large-language-model-applications/)
- [OWASP Machine Learning Security Top Ten](https://owasp.org/www-project-machine-learning-security-top-10/)
- [MITRE ATLAS™ (Adversarial Threat Landscape for Artificial-Intelligence Systems)](https://atlas.mitre.org/)
- [OWASP DevSecOps](https://devsecops.owasp.org/)
- [OWASP Devsecops Maturity Model](https://owasp.org/www-project-devsecops-maturity-model/)
- [OWASP DevSecOps Guideline](https://owasp.org/www-project-devsecops-guideline/)
- [DevSecOps-Playbook](https://github.com/6mile/DevSecOps-Playbook)

## Tools

<table>
  <thead>
    <tr>
      <th>Pipeline</th>
      <th>Stages</th>
      <th>Tool</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="20">MLSecOps</td>
      <td rowspan="2">Stage 1</td>
      <td><a href="https://pre-commit.com/">Pre-Commit Hook Scans</td>
      <td>A framework for managing and maintaining multi-language pre-commit hooks.</td>
    </tr>
    <tr>
        <td>IDE plugins<br><a href="https://marketplace.visualstudio.com/items?itemName=AquaSecurityOfficial.trivy-vulnerability-scanner">Trivy Vulnerability Scanner</a><br><a href="https://marketplace.visualstudio.com/items?itemName=trunk.io">Trunk Check</a>
      </td>
        <td><br>Comprehensive vulnerability scanner for containers and other artifacts.<br>Automated Code Quality for Teams: universal formatting, linting, static analysis, and security.</td>
    </tr>
    <tr>
        <td rowspan="2">Stage 2</td>
        <td><a href="https://aws.amazon.com/s3/">AWS S3 bucket</a></td>
        <td>A bucket is a container for objects stored in Amazon S3.</td>
    </tr>
    <tr>
        <td><a href="https://www.sonatype.com/products/sonatype-nexus-repository">Nexus Repository</a></td>
        <td>Sonatype Nexus Repository</td>
    </tr>
    <tr>
        <td rowspan="6">Stage 3</td>
        <td><a href="https://gitleaks.io/">Gitleak</a></td>
        <td>Secret scanner for git repositories, files, and directories.</td>
    </tr>
    <tr>
        <td><a href="https://www.sonatype.com/products/sonatype-nexus-repository">Sonarqube</a></td>
        <td>Open-source platform for continuous inspection of code quality.</td>
    </tr>
    <tr>
        <td><a href="https://aquasecurity.github.io/trivy/">Trivy</a></td>
        <td>Comprehensive vulnerability scanner for containers and other artifacts.</td>
    </tr>
    <tr>
        <td><a href="https://horusec.io/">Horusec</a></td>
        <td>Tool to perform static code analysis to identify security flaws.</td>
    </tr>
    <tr>
        <td><a href="https://owasp.org/www-project-dependency-check/">OWASP Dependency-Check</a></td>
        <td>Tool that identifies project dependencies and checks for known vulnerabilities.</td>
    </tr>
    <tr>
        <td><a href="https://nbdefense.ai/">NB Defense</a></td>
        <td>Security tool for Jupyter notebooks, scanning for vulnerabilities and risks.</td>
    </tr>
    <tr>
    <tr>
        <td rowspan="1">Stage 4</td>
        <td>Quality Gate</td>
        <td>Define a rule/ policy for test result.</td>
    </tr>
    <tr>
        <td rowspan="2">Stage 5</td>
        <td><a href="https://keras.io/api/callbacks/early_stopping/">EarlyStopping</a></td>
        <td>Stop training when a monitored metric has stopped improving.</td>
    </tr>
    <tr>
        <td><a href="https://scikit-learn.org/stable/modules/generated/sklearn.model_selection.KFold.html">KFold</a></td>
        <td>K-Fold cross-validator.</td>
    </tr>
    <tr>
        <td rowspan="1">Stage 6</td>
        <td><a href="https://scikit-learn.org/stable/modules/model_evaluation.html">EarlyStopping</a></td>
        <td>Metrics and scoring: quantifying the quality of predictions.</td>
    </tr>
    <tr>
        <td rowspan="3">Stage 7</td>
        <td><a href="https://github.com/protectai/modelscan">modelscan</a></td>
        <td>Protection Against ML Model Serialization Attacks.</td>
    </tr>
    <tr>
        <td><a href="https://github.com/deadbits/vigil-llm">Vigil</a></td>
        <td>LLM prompt injection and security scanner.</td>
    </tr>
    <tr>
        <td><a href="https://github.com/leondz/garak">Garak</a></td>
        <td>LLM vulnerability scanner.</td>
    </tr>
    <tr>
        <td rowspan="1">Stage 8</td>
        <td>Quality Gate</td>
        <td>Define a rule/ policy for test result.</td>
    </tr>
    <tr>
        <td rowspan="1">Stage 9</td>
        <td><a href="https://keras.io/guides/serialization_and_saving/">Save model</a></td>
        <td>Save, serialize, and export models.</td>
    </tr>
    <tr>
      <td rowspan="30">DevSecOps</td>
      <td rowspan="2">Stage 1</td>
      <td><a href="https://pre-commit.com/">Pre-Commit Hook Scans</td>
      <td>A framework for managing and maintaining multi-language pre-commit hooks.</td>
    </tr>
    <tr>
        <td>IDE plugins<br><a href="https://marketplace.visualstudio.com/items?itemName=AquaSecurityOfficial.trivy-vulnerability-scanner">Trivy Vulnerability Scanner</a><br><a href="https://marketplace.visualstudio.com/items?itemName=trunk.io">Trunk Check</a>
      </td>
        <td><br>Comprehensive vulnerability scanner for containers and other artifacts.<br>Automated Code Quality for Teams: universal formatting, linting, static analysis, and security.</td>
    </tr>
    <tr>
        <td rowspan="2">Stage 2</td>
        <td><a href="https://aws.amazon.com/s3/">AWS S3 bucket</a></td>
        <td>A bucket is a container for objects stored in Amazon S3.</td>
    </tr>
    <tr>
        <td><a href="https://www.sonatype.com/products/sonatype-nexus-repository">Nexus Repository</a></td>
        <td>Sonatype Nexus Repository</td>
    </tr>
    <tr>
        <td rowspan="7">Stage 3</td>
        <td><a href="https://gitleaks.io/">Gitleak</a></td>
        <td>Secret scanner for git repositories, files, and directories.</td>
    </tr>
    <tr>
        <td><a href="https://www.sonatype.com/products/sonatype-nexus-repository">Sonarqube</a></td>
        <td>Open-source platform for continuous inspection of code quality.</td>
    </tr>
    <tr>
        <td><a href="https://aquasecurity.github.io/trivy/">Trivy</a></td>
        <td>Comprehensive vulnerability scanner for containers and other artifacts.</td>
    </tr>
    <tr>
        <td><a href="https://horusec.io/">Horusec</a></td>
        <td>Tool to perform static code analysis to identify security flaws.</td>
    </tr>
    <tr>
        <td><a href="https://owasp.org/www-project-dependency-check/">OWASP Dependency-Check</a></td>
        <td>Tool that identifies project dependencies and checks for known vulnerabilities.</td>
    </tr>
    <tr>
        <td><a href="https://www.checkov.io/">Checkov</a></td>
        <td>Checkov scans cloud infrastructure configurations to find misconfigurations.</td>
    </tr>
    <tr>
        <td><a href="https://github.com/terraform-linters/tflint">TFlint</a></td>
        <td>A Pluggable Terraform Linter.</td>
    </tr>
    <tr>
        <td rowspan="1">Stage 4</td>
        <td>Quality Gate</td>
        <td>Define a rule/ policy for test result.</td>
    </tr>
    <tr>
        <td rowspan="1">Stage 5</td>
        <td><a href="https://docs.docker.com/reference/cli/docker/buildx/build/">Build image</a></td>
        <td>Docker buildx build.</td>
    </tr>
    <tr>
        <td rowspan="4">Stage 6</td>
        <td><a href="https://docs.snyk.io/scan-using-snyk/snyk-container/scan-container-images">Synk</a></td>
        <td>Snyk Container helps you find and fix vulnerabilities in container images, based on container registry scans.</td>
    </tr>
    <tr>
        <td><a href="https://docs.docker.com/scout/">Docker Scount</a></td>
        <td>Scan docker image.</td>
    </tr>
    <tr>
        <td><a href="https://portswigger.net/burp">Burp Suite</a></td>
        <td>The class-leading vulnerability scanning, penetration testing, and web app security platform.</td>
    </tr>
    <tr>
        <td><a href="https://www.acunetix.com/">Acunetix</a></td>
        <td>Acunetix is an end-to-end web security scanner.</td>
    </tr>
    <tr>
        <td rowspan="1">Stage 7</td>
        <td>Quality Gate</td>
        <td>Define a rule/ policy for test result.</td>
    </tr>
    <tr>
        <td rowspan="1">Stage 8</td>
        <td><a href="https://docs.docker.com/reference/cli/docker/image/save/">Save image</td>
        <td>Save one or more images to a tar archive .</td>
    </tr>
    <tr>
        <td rowspan="2">Stage 9</td>
        <td><a href="https://www.tenable.com/products/nessus">Nessus</a></td>
        <td>Nessus Vulnerability Scanner.</td>
    </tr>
    <tr>
        <td><a href="https://nmap.org/">Nmap</a></td>
        <td>Security Scanner, Port Scanner, & Network Exploration Tool.</td>
    </tr>
    <tr>
        <td rowspan="1">Stage 10</td>
        <td><a href="https://github.com/noobpk/gemini-self-protector">gemini-self-protector</a></td>
        <td>Gemini - Runtime Application Self Protection Solution (G-SP).</td>
    </tr>
  </tbody>
</table>


## Contribution

We welcome contributions from the community to help us expand and improve this repository. If you have suggestions, tools, or resources that you believe should be included, please feel free to submit a pull request or open an issue.

Thank you for visiting our repository. We hope you find it a valuable resource in your journey towards secure and effective machine learning operations.
