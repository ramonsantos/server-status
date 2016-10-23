free | grep -v 'Swap' | grep -v 'used' |  awk '{print  $2, $3, $4, $6}'
