### Docker Installtion

Simply by the command:
```bash
sudo apt install docker.io -y
```
### Install Kubernetes Server
To install all binaries that we need to interact with the kubernetes server, we need to get the tar.gz package as follows:
```bash
wget https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/kubernetes-server-linux-amd64.tar.gz
```

After, we need to depackage the `kubernetes-server-linux-amd64.tar.gz` tar:
```bash
tar -xzf kubernetes-server-linux-amd64.tar.gz
```

Now let's discover binaries to in the kubernetes/server/bin:
```
cd kubernetes/server/bash
ls
```
The binaries are:

```
apiextensions-apiserver  kube-apiserver.docker_tag  kube-controller-manager.docker_tag  kube-proxy             kube-scheduler             kubeadm          kubelet
kube-aggregator          kube-apiserver.tar         kube-controller-manager.tar         kube-proxy.docker_tag  kube-scheduler.docker_tag  kubectl          mounter
kube-apiserver           kube-controller-manager    kube-log-runner                     kube-proxy.tar         kube-scheduler.tar         kubectl-convert
```

Now, we need to move some binaries to /usr/bin/ so we can use them easily

```bash
sudo mv kubectl kubelet kube-proxy kube-apiserver kube-controller-manager kube-scheduler /usr/bin/
```

- Now we finished the setup of kubernetes

Le's create a directory inside /etc in which we can start our kubelet
```bash
sudo mkdir -p /etc/kubernetes/manifests
```
Then, we can start `kubelet` with single command
```bash
sudo kubelet --pod-manifest-path /etc/kubernetes/manifests &> /etc/kubernetes/kubelet.log &
```

--pod-manifest-path /etc/kubernetes/manifests: This flag specifies the directory where the kubelet should look for pod manifests, which are YAML or JSON files that describe the desired state of pods in the cluster. In this case, the manifests are located in the directory /etc/kubernetes/manifests.

&> /etc/kubernetes/kubelet.log: This redirects the standard output and standard error of the kubelet process to a log file located at /etc/kubernetes/kubelet.log. This is useful for troubleshooting issues that may arise with kubelet.

- We can check if the process is running by just taping:
```bash
ps au | grep kubelet
```
We get an output like this:
```
root@DESKTOP-7Q73KUH:~# ps au | grep kubelet
root      1375  0.0  0.0  12064  1280 tty1     S    14:03   0:00 grep --color=auto kubelet
[1]+  Exit 1                  kubelet --pod-manifest-path /etc/kubernetes/manifests &> /etc/kubernetes/kubelet.log
```

- Well, let us open the kubelet.log to see what happened exactly
```
root@DESKTOP-7Q73KUH:~# ls /etc/kubernetes
kubelet.log  manifests
root@DESKTOP-7Q73KUH:~# head /etc/kubernetes/kubelet.log
Flag --pod-manifest-path has been deprecated, This parameter should be set via the config file specified by the Kubelet's --config flag. See https://kubernetes.io/docs/tasks/administer-cluster/kubelet-config-file/ for more information.
E0228 14:03:22.021823    1366 run.go:74] "command failed" err="failed to validate kubelet flags: the container runtime endpoint address was not specified or empty, use --container-runtime-endpoint to set"
```
Here, the container runtime endpoint address was not specified or is empty. This means that the kubelet command was unable to communicate with the container runtime (e.g. Docker) to start and manage containers.

Now, we will create a file inside /etc/kubernetes/manifest
```

