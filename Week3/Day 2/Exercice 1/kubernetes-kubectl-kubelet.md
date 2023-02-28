### Install Kubernetes Server
To install all binaries that we need to interact with the kubernetes server, we need to get the tar.gz package as follows:
```
wget https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/kubernetes-server-linux-amd64.tar.gz
```

After, we need to depackage the `kubernetes-server-linux-amd64.tar.gz` tar:
```
tar -xzf kubernetes-server-linux-amd64.tar.gz
```

Now let's discover binaries to in the kubernetes/server/bin:
```

```


<pre>
    <code>
    ```bash
    cd kubernetes/server/bash
    ls
    <!-- apiextensions-apiserver  kube-apiserver.docker_tag  kube-controller-manager.docker_tag  kube-proxy             kube-scheduler             kubeadm          kubelet
    kube-aggregator          kube-apiserver.tar         kube-controller-manager.tar         kube-proxy.docker_tag  kube-scheduler.docker_tag  kubectl          mounter
    kube-apiserver           kube-controller-manager    kube-log-runner                     kube-proxy.tar         kube-scheduler.tar         kubectl-convert -->
    ```
    </code>
</pre>