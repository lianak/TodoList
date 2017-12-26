# -*- mode: ruby -*-
# vi: set ft=ruby :

$script = <<SCRIPT
echo I am provisioning...
date > /etc/vagrant_provisioned_at
SCRIPT

Vagrant.configure("2") do |config|
  config.vm.provision "shell", inline: $script
end

Vagrant::Config.run do |config|
  config.vm.box = "ubuntu/xenial64"
  config.vm.box_url = "https://atlas.hashicorp.com/ubuntu/boxes/xenial64"
  config.vm.host_name = "todo-list" 

  config.vm.provision :shell, :path => "bootstrap.sh"
  
  # PostgreSQL Server port forwarding
  config.vm.forward_port 8081, 8081
end
