echo "Distro:" `cat /etc/*-release | grep PRETTY_NAME`
echo "Kernel:" `uname -o -m -v -r`
