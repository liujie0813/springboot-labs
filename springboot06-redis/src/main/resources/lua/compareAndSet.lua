-- 如果 KEYS[1] 对应的 VALUE 不等于 ARGV[1]
if redis.call('GET', KEYS[1]) ~= ARGV[1] then
    -- 返回 0
    return 0
end
-- 否则将 KEYS[1] 对应的值设置为 ARGV[2]
redis.call('SET', KEYS[1], ARGV[2])
return 1